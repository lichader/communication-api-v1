package com.diangezan.api.communication;
import com.diangezan.api.communication.web.model.CreateCommunicationRequest;
import com.diangezan.api.communication.web.model.CreateCommunicationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;

@Slf4j
@RestController
public class CommunicationsController {
    private final static String MESSAGE_TEMPLATE = "Sent %s to %s with content: %s on machine: %s";

    @PostMapping("/communications")
    public ResponseEntity<CreateCommunicationResponse> createCommunication(@RequestBody CreateCommunicationRequest request) {
        var data = request.getData();

        if (StringUtils.isEmpty(data.getDestination())
            || StringUtils.isEmpty(data.getType())
            || StringUtils.isEmpty(data.getContent())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body is invalid");
        }

        var hosstname = "Unknown";

        try {
            hosstname = InetAddress.getLocalHost().getHostName();
        } catch (Exception ex){
            log.error("Unable to get host name");
        }

        log.info(String.format(MESSAGE_TEMPLATE, data.getType(), data.getDestination(), data.getContent(), hosstname));

        var response = new CreateCommunicationResponse(hosstname);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
