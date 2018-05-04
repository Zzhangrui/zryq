package com.zryq.cms.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Service;


/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/5/4
 * Time: 17:14
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PublishArticleJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {

        System.out.println("shardingContext.getJobName() = " + shardingContext.getJobName());
    }
}
