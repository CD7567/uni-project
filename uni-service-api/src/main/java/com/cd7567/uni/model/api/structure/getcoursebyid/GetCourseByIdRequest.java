package com.cd7567.uni.model.api.structure.getcoursebyid;

import java.util.List;

public class GetCourseByIdRequest {
    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
