package de.rsasoft.blockchainapi;

import de.rsasoft.blockchainapi.domain.Block;
import de.rsasoft.blockchainapi.domain.BlockChain;
import de.rsasoft.blockchainapi.utils.ShaUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static de.rsasoft.blockchainapi.utils.ShaUtils.*;

@SpringBootApplication
public class BlockchainApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BlockchainApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Create Blockchain Object");
//		BlockChain blockChain = new BlockChain();
//		System.out.println(blockChain.getBlockList());
//
//		System.out.println("Mining a new Block");
//
//		Block<Object> previousBlock = blockChain.getPreviousBlock();
//		int previousProofOfNumber = previousBlock.getProof();
//		int newProofOfNumber = blockChain.getNextProofOfWorkNumber(previousProofOfNumber);
//		String previousHash = blockChain.hash(previousBlock);
//		Block<Object> newBlock = blockChain.createBlock(newProofOfNumber,previousHash);
//		System.out.println(newBlock);
//     	System.out.println(blockChain.getBlockList());

//		System.out.println("Testing Encode SHA Algorithm");
//		String algorithm = "SHA3-256";
//		String pText = "Hello World";
//		System.out.println(String.format(OUTPUT_FORMAT, "Input (string)", pText));
//		System.out.println(String.format(OUTPUT_FORMAT, "Input (length)", pText.length()));
//
//		byte[] shaInBytes = ShaUtils.encode(pText.getBytes(UTF_8));
//		System.out.println(String.format(OUTPUT_FORMAT, algorithm + " (hex) ", bytesToHex(shaInBytes)));
//		// fixed length, 32 bytes, 256 bits.
//		System.out.println(String.format(OUTPUT_FORMAT, algorithm + " (length)", shaInBytes.length));
	}
}
