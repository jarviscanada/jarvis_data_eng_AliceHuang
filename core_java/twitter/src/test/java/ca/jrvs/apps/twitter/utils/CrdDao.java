package ca.jrvs.apps.twitter.utils;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public interface CrdDao<T, ID> {

  /**
   * Create an entity(Tweet) to the underlying storage
   * @param entity entity that to be created
   * @return created entity
   */
  T create(T entity) throws UnsupportedEncodingException, URISyntaxException;

  /**
   * Find an entity(Tweet) by its id
   * @param id entity id
   * @return Tweet entity
   */
  T findById(ID id) throws URISyntaxException;

  /**
   * Delete an entity(Tweet) by its ID
   * @param id of the entity to be deleted
   * @return deleted entity
   */
  T deleteById(ID id) throws URISyntaxException;
}
