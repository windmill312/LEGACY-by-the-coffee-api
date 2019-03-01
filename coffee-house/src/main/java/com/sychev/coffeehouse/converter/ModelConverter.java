package com.sychev.coffeehouse.converter;

import com.sychev.coffeehouse.grpc.model.v1.GAddCafeRequest;
import com.sychev.coffeehouse.grpc.model.v1.GCafeInfo;
import com.sychev.coffeehouse.grpc.model.v1.GLocation;
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

    public static GCafeInfo convert(CafeEntity entity) {
        return GCafeInfo.newBuilder()
                .setCafeUid(convert(entity.getUidCafe()))
                .setCafeName(entity.getName())
                .setDescription(entity.getDescription())
                .setLocation(convert(entity.getLatitude(), entity.getLongitude()))
                .setOwnerUid(convert(entity.getOwnerUid()))
                .build();
    }

    public static CafeEntity convert(GCafeInfo entity) {
        return new CafeEntity()
                .setUidCafe(convert(entity.getCafeUid()))
                .setName(entity.getCafeName())
                .setDescription(entity.getDescription())
                .setLatitude(entity.getLocation().getLatitude())
                .setLongitude(entity.getLocation().getLongitude())
                .setOwnerUid(convert(entity.getOwnerUid()));
    }

    public static UUID convert(GUuid guuid) {
        return UUID.fromString(guuid.getUuid());
    }

    private static GLocation convert(Double latitude, Double longitude) {
        return GLocation.newBuilder()
                .setLatitude(latitude)
                .setLongitude(longitude)
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
}
