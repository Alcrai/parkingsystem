package com.parkit.parkingsystem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.parkit.parkingsystem.util.InputReaderUtil;

@ExtendWith(MockitoExtension.class)
public class InputReaderUtilTest {
	
	@Mock 
	InputReaderUtil inputReaderUtil;
	
	@Mock
	Scanner scan ;
			 
	 @Test
	 void readSelectionTest() {
		 when(inputReaderUtil.readSelection()).thenReturn(1);
		 assertThat(inputReaderUtil.readSelection()).isEqualTo(1);
		 verify(inputReaderUtil).readSelection();
	 }
	 
	 @Test
	 void  readVehicleRegistrationNumberTest() throws Exception {
		 when(inputReaderUtil.readVehicleRegistrationNumber()).thenReturn("ABCDEF");
		 assertThat(inputReaderUtil.readVehicleRegistrationNumber()).isEqualTo("ABCDEF");
		 verify(inputReaderUtil).readVehicleRegistrationNumber();
		 
	 }
	 
	 
}
