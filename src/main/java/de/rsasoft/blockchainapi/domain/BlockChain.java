package de.rsasoft.blockchainapi.domain;

import de.rsasoft.blockchainapi.utils.ShaUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@Builder
@Component
public class BlockChain {
    private  List<Block<Object>> blockList;

    public BlockChain(){
        this.blockList = new ArrayList<>();
        createBlock(1, "0");
    }

    public Block<Object> createBlock(final int proof, final String previousHash){

        final Block<Object> block = Block.builder().index(this.blockList.size()+1)
                                                    .data(null)
                                                    .previousHash(previousHash)
                                                    .proof(proof)
                                                    .timeStamp(Instant.now())
                                                    .build();
        this.blockList.add(block);
        return block;

    }


    public Block<Object> getPreviousBlock(){
        return this.blockList.get(blockList.size()-1);
    }


    public Integer getNextProofOfWorkNumber(final Integer previousProofOfWorkNumber){
         Integer newProofOfWorkNumber = 1;
         boolean isValidProofOfWorkNumber = false;
         do {
             String hashOperationSubstring = createHashOperation(newProofOfWorkNumber, previousProofOfWorkNumber).substring(0,4);
             if(hashOperationSubstring.equals("0000")){
                 isValidProofOfWorkNumber = true;
             }else {
                 newProofOfWorkNumber++;
             }
         }while (!isValidProofOfWorkNumber);

        return newProofOfWorkNumber;
    }

    public String hash(final Block<Object> block){
        return ShaUtils
                .bytesToHex(ShaUtils.encode(block.toString()
                        .getBytes(StandardCharsets.UTF_8)));
    }

    public String createHashOperation(final int proof, final int previousProof ){
        Double polynomialEquation = Math.pow(proof,2)- Math.pow(previousProof,2);
        return ShaUtils
                .bytesToHex(ShaUtils.encode(polynomialEquation.toString()
                .getBytes(StandardCharsets.UTF_8)));
    }

    public boolean isBlockchainValid(){
        Block<Object> previousBlock = this.blockList.get(0);
        int blockIndex = 1;
        while (blockIndex < this.blockList.size()){
            Block<Object> actualBlock = blockList.get(blockIndex);
            if(!actualBlock.getPreviousHash().equals(hash(previousBlock))){
                return false;
            }
            int previousBlockProof = previousBlock.getProof();
            int actualBlockProof = actualBlock.getProof();
            String hashOperationSubstring = createHashOperation(actualBlockProof,previousBlockProof).substring(0,4);
            if(!hashOperationSubstring.equals("0000")){
                return false;
            }else {
                previousBlock = actualBlock;
                blockIndex++;
            }
        }
        return true;
    }


}
