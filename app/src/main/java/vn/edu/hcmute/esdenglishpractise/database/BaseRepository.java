package vn.edu.hcmute.esdenglishpractise.database;

import java.util.List;

/**
 * Created by nddv9 on 19/05/2017.
 */

public interface BaseRepository<T> {
    List<T> findAll() throws Exception;
    T findById(int id) throws Exception;
}
