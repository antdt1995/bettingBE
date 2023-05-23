package com.axonactive.personalproject.authenticate;


import com.axonactive.personalproject.service.customDto.CustomRegisterDto;
import com.axonactive.personalproject.service.dto.CustomerDto;
import com.axonactive.personalproject.service.implement.AccountDetailImpl;
import com.axonactive.personalproject.jwt.LoginRequest;
import com.axonactive.personalproject.jwt.JwtResponse;
import com.axonactive.personalproject.jwt.JwtUtils;
import com.axonactive.personalproject.service.dto.AccountDto;
import com.axonactive.personalproject.service.implement.AccountServiceImpl;
import com.axonactive.personalproject.service.implement.CustomerImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthControllerImpl implements AuthController {
    private final AuthenticationManager authenticationManager;
    private final AccountServiceImpl accountService;
    private final JwtUtils jwtUtils;


    @Override
    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        AccountDetailImpl accountDetail = (AccountDetailImpl) authentication.getPrincipal();
        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt, accountDetail.getUsername(), roles));
    }

    @Override
    public ResponseEntity<CustomRegisterDto> registerAccount(CustomRegisterDto customRegisterDto) {
        log.info("Create account on customer ");
        CustomRegisterDto account = accountService.createAccount(customRegisterDto);
        return ResponseEntity.created(URI.create("/auth/accounts/" + customRegisterDto.getId())).body(account);
    }
}
