package com.zryq.cms.es.service;

import com.zryq.cms.admin.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/5/4
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */
public interface ArticleEsRepository extends ElasticsearchRepository<Article,Long> {
}
