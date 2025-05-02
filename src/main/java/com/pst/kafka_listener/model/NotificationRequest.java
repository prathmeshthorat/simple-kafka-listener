package com.pst.kafka_listener.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotificationRequest {

    private String payload;
    private String channel;
    private String channelKey;
    private String message;

}
