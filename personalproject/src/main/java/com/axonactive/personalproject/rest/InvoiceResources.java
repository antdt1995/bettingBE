package com.axonactive.personalproject.rest;

import com.axonactive.personalproject.rest.admin.InvoiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class InvoiceResources implements InvoiceApi {
}
