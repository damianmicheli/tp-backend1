package com.dh.g2.web.rest;

import com.dh.g2.domain.Wallet;
import com.dh.g2.service.WalletCreationCommand;
import com.dh.g2.web.rest.model.in.WalletRequestModel;
import com.dh.g2.web.rest.model.out.CommonRestResponse;
import com.dh.g2.web.rest.model.out.WalletRestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
@Slf4j
public class WalletRestController {

    private final WalletCreationCommand walletCreationCommand;

    public WalletRestController(WalletCreationCommand walletCreationCommand) {
        this.walletCreationCommand = walletCreationCommand;
    }

    @PostMapping
    ResponseEntity<CommonRestResponse<WalletRestResponse>> save(@RequestBody WalletRequestModel requestModel){
        log.info("Getting invoke POST to /wallet with request body {}", requestModel );
        WalletCreationCommand.Data data = WalletCreationCommand.Data
                .builder()
                .documentType(requestModel.getDocumentType())
                .documentNumber(requestModel.getDocumentNumber())
                .coinCode(requestModel.getCoinCode())
                .build();
        Wallet response = walletCreationCommand.execute(data);
        log.info("Execution response {}", response);
        return ResponseEntity.ok(CommonRestResponse.<WalletRestResponse>builder()
                .success(true)
                .response(WalletRestResponse.fromDomain(response))
                .build());
    }
}
