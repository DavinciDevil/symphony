package org.b3log.symphony.repository;

import org.b3log.latke.Keys;
import org.b3log.latke.repository.*;
import org.b3log.latke.repository.annotation.Repository;
import org.b3log.latke.repository.jdbc.util.JdbcRepositories;
import org.b3log.symphony.model.Book;
import org.b3log.symphony.model.Test;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.inject.Inject;


/**
 * Created by Administrator on 17/3/27.
 */
@Repository
public class LccTestRepository extends AbstractRepository{


    public LccTestRepository() {
        super("test");

    }
    public JSONObject getByName(final String name) throws RepositoryException {
        final Query query = new Query().setFilter(
                new PropertyFilter(Test.NAME, FilterOperator.EQUAL, name)
        );
        JSONObject result = get(query);
        final JSONArray test = result.optJSONArray(Keys.RESULTS);
        if (test.length() < 1) {
            return null;
        }
        return test.optJSONObject(0);
    }
}
