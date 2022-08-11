package com.assessments.cloudplay.string_compressor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import com.assessments.cloudplay.string_compressor.decoders.Decoder;
import com.assessments.cloudplay.string_compressor.encoders.Encoder;

/**
 * This class is to test Encoder and Decoder solution
 *  
 * @author stevenguadamuz
 *
 */
public class AppTest 
{
	
	private final Logger logger = Logger.getLogger(AppTest.class.getName());

    
    @Test
    public void testCompressor() {
    	
    	String original = "AAAAABBBBCCCC";
    	
    	String encoded = Encoder.encode(original);
    	
    	String decoded = Decoder.decode(encoded);
    	
    	assertEquals(original, decoded);
    	
    	assertTrue(original.length() > encoded.length());
    	
    	assertEquals(original.length(), decoded.length());
    	
    	logger.log(Level.INFO, String.format("Original input %s", original));
    	logger.log(Level.INFO, String.format("Input encoded %s", encoded));
    	logger.log(Level.INFO, String.format("Encode restore %s", decoded));

    }
    
    @Test
    public void testCompressorWhenDecodedIsGreather() {
    	
    	String original = "A";
    	
    	String encoded = Encoder.encode(original);
    	
    	String decoded = Decoder.decode(encoded);
    	
    	assertEquals(original, decoded);
    	
    	assertTrue(original.length() < encoded.length());
    	
    	assertEquals(original.length(), decoded.length());
    	

    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEncodeEmpty() {
    	   	
    	Encoder.encode("");
    	
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDecodeEmpty() {
    	    	
    	Decoder.decode("");
    	
    }
}
