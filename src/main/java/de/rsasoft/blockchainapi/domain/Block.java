package de.rsasoft.blockchainapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Block<T> {

    private int index;
    private T data;
    private Instant timeStamp;
    private int proof;
    private  String previousHash;
}
