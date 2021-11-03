package de.rsasoft.blockchainapi;

import de.rsasoft.blockchainapi.domain.Block;
import de.rsasoft.blockchainapi.domain.BlockChain;
import de.rsasoft.blockchainapi.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlockchainController {

    @Autowired
    BlockChain blockChain;

    @GetMapping("/mineblock")
    public ResponseEntity<ResponseWrapper<Block<Object>>> mineBlock(){
        Block<Object> previousBlock = blockChain.getPreviousBlock();
        int previousProofOfNumber = previousBlock.getProof();
        int newProofOfNumber = blockChain.getNextProofOfWorkNumber(previousProofOfNumber);
        String previousHash = blockChain.hash(previousBlock);
        Block<Object> newBlock = blockChain.createBlock(newProofOfNumber,previousHash);
        final ResponseWrapper<Block<Object>> responseWrapper = new ResponseWrapper<>(true, "NEW BLOCK MINED", newBlock);
        return responseWrapper.createResponse(HttpStatus.OK);
    }

    @GetMapping("/blockchain")
    public ResponseEntity<ResponseWrapper<List<Block<Object>>>> getBlockChain(){
        final ResponseWrapper<List<Block<Object>>> responseWrapper = new ResponseWrapper<>(true, "SUCCESS", blockChain.getBlockList());
        return responseWrapper.createResponse(HttpStatus.OK);
    }

    @GetMapping("/isblockchainvalid")
    public ResponseEntity<ResponseWrapper<String>> isBlockChainValid(){
        String message = null;
        if(blockChain.isBlockchainValid()){
            message = "The BlockChain is Valid";
        }
        return new ResponseWrapper<>(true,"SUCCESS", message).createResponse(HttpStatus.OK);
    }
}
