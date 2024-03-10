package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;

public class D25 extends TranslatorBlock
	{

		public D25(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
		{
			super(blockId, translator, codePrefix, codeSuffix, label);
		}

		@Override
		public String toCode() throws SocketNullException {
			return codePrefix + "25" + codeSuffix;
		}
		
	}