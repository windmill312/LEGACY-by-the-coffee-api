package com.sychev.coffeehouse.converter;

import com.sychev.coffeehouse.grpc.model.v1.GAddCafeRequest;
import com.sychev.coffeehouse.grpc.model.v1.GCafeInfo;
import com.sychev.coffeehouse.model.entity.CafeEntity;
import com.sychev.common.grpc.model.GPage;
import com.sychev.common.grpc.model.GPageable;
import com.sychev.common.grpc.model.GUuid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class ModelConverter {

    public static GPage convert(Page page) {
        return GPage.newBuilder()
                .setNumber(page.getNumber())
                .setSize(page.getSize())
                .setTotalElements(page.getTotalElements())
                .build();
    }

    public static Pageable convert(GPageable pageable) {
        return PageRequest.of(pageable.getPage(), pageable.getSize());
    }

    public static GUuid convert(UUID uuid) {
        return GUuid.newBuilder()
                .setUuid(String.valueOf(uuid))
                .build();
    }

    public static UUID convert(GUuid guuid) {
        return UUID.fromString(guuid.getUuid());
    }

    public static GCafeInfo convert(CafeEntity entity) {
        return GCafeInfo.newBuilder()
                .setCafeUid(convert(entity.getUidCafe()))
                .setCafeName(entity.getName())
                .setLocation(entity.getLocation())
                .setProducts(entity.getProducts())
                .build();
    }

    /*public static GInterviewQuestionInfo convert(QuestionEntity entity) {
        return GInterviewQuestionInfo.newBuilder()
                .setQuestionUid(convert(entity.getQuestionUid()))
                .setQuestionName(entity.getQuestionName())
                .setCategory(entity.getCategory())
                .setQuestionText(entity.getQuestionText())
                .setQuestionAnswer(entity.getQuestionAnswer())
                .build();
    }*/

    public static CafeEntity convert(GAddCafeRequest request) {
        return new CafeEntity()
                .setName(request.getCafe().getCafeName())
                .set(request.getQuestionCategory())
                .setQuestionText(request.getQuestionText())
                .setQuestionAnswer(request.getQuestionAnswer());
    }
}

}
