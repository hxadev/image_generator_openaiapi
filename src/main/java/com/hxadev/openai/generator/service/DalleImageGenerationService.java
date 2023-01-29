package com.hxadev.openai.generator.service;

import com.hxadev.openai.generator.model.dto.GenerationInfo;

public interface DalleImageGenerationService {
    
    public void generate(GenerationInfo info) throws Exception;

}
