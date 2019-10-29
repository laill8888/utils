package com.laill;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 创建人：laill
 * @version 版本号：V1.0
 * <p>
 * **************************修订记录***************************************
 * <p>
 * 2019年06月06日 laill 创建该类功能。
 * <p>
 * ***********************************************************************
 * </p>
 * @ClassName 类名：BeanCopyUtils
 * @Description 功能说明：实体类复制
 * <p>
 * TODO
 * </p>
 * ***********************************************************************
 * @date 创建日期：2019年06月06日
 */
public final class BeanCopyUtils extends BeanUtil {
    private BeanCopyUtils() {
    }

    public static <T, P> P copyProperties(T source, Class<P> target) {
        try {
            P p = target.newInstance();
            BeanUtil.copyProperties(source, p);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 复制集合
     *
     * @param source
     * @param target
     * @param <T>
     * @param <P>
     * @return
     */
    public static <T, P> List<P> copyProperties(List<T> source, Class<P> target) {
        if (CollectionUtil.isEmpty(source)) {
            return null;
        }
        List<P> dtos = new ArrayList<>(source.size());
        source.stream().forEach(user1 -> {
            dtos.add(copyProperties(user1, target));
        });
        return dtos;
    }


}
