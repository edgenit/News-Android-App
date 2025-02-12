package de.luhmer.owncloudnewsreader.database.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table RSS_ITEM.
*/
public class RssItemDao extends AbstractDao<RssItem, Long> {

    public static final String TABLENAME = "RSS_ITEM";

    /**
     * Properties of entity RssItem.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property FeedId = new Property(1, long.class, "feedId", false, "FEED_ID");
        public final static Property Link = new Property(2, String.class, "link", false, "LINK");
        public final static Property Title = new Property(3, String.class, "title", false, "TITLE");
        public final static Property Body = new Property(4, String.class, "body", false, "BODY");
        public final static Property Read = new Property(5, Boolean.class, "read", false, "READ");
        public final static Property Starred = new Property(6, Boolean.class, "starred", false, "STARRED");
        public final static Property Author = new Property(7, String.class, "author", false, "AUTHOR");
        public final static Property Guid = new Property(8, String.class, "guid", false, "GUID");
        public final static Property GuidHash = new Property(9, String.class, "guidHash", false, "GUID_HASH");
        public final static Property Read_temp = new Property(10, Boolean.class, "read_temp", false, "READ_TEMP");
        public final static Property Starred_temp = new Property(11, Boolean.class, "starred_temp", false, "STARRED_TEMP");
        public final static Property LastModified = new Property(12, java.util.Date.class, "lastModified", false, "LAST_MODIFIED");
        public final static Property PubDate = new Property(13, java.util.Date.class, "pubDate", false, "PUB_DATE");
        public final static Property EnclosureLink = new Property(14, String.class, "enclosureLink", false, "ENCLOSURE_LINK");
        public final static Property EnclosureMime = new Property(15, String.class, "enclosureMime", false, "ENCLOSURE_MIME");
    };

    private DaoSession daoSession;

    private Query<RssItem> feed_RssItemListQuery;

    public RssItemDao(DaoConfig config) {
        super(config);
    }
    
    public RssItemDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'RSS_ITEM' (" + //
                "'_id' INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "'FEED_ID' INTEGER NOT NULL ," + // 1: feedId
                "'LINK' TEXT," + // 2: link
                "'TITLE' TEXT," + // 3: title
                "'BODY' TEXT," + // 4: body
                "'READ' INTEGER," + // 5: read
                "'STARRED' INTEGER," + // 6: starred
                "'AUTHOR' TEXT NOT NULL ," + // 7: author
                "'GUID' TEXT NOT NULL ," + // 8: guid
                "'GUID_HASH' TEXT NOT NULL ," + // 9: guidHash
                "'READ_TEMP' INTEGER," + // 10: read_temp
                "'STARRED_TEMP' INTEGER," + // 11: starred_temp
                "'LAST_MODIFIED' INTEGER," + // 12: lastModified
                "'PUB_DATE' INTEGER," + // 13: pubDate
                "'ENCLOSURE_LINK' TEXT," + // 14: enclosureLink
                "'ENCLOSURE_MIME' TEXT);"); // 15: enclosureMime
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_RSS_ITEM_FEED_ID ON RSS_ITEM" +
                " (FEED_ID);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'RSS_ITEM'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, RssItem entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getFeedId());
 
        String link = entity.getLink();
        if (link != null) {
            stmt.bindString(3, link);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(4, title);
        }
 
        String body = entity.getBody();
        if (body != null) {
            stmt.bindString(5, body);
        }
 
        Boolean read = entity.getRead();
        if (read != null) {
            stmt.bindLong(6, read ? 1l: 0l);
        }
 
        Boolean starred = entity.getStarred();
        if (starred != null) {
            stmt.bindLong(7, starred ? 1l: 0l);
        }
        stmt.bindString(8, entity.getAuthor());
        stmt.bindString(9, entity.getGuid());
        stmt.bindString(10, entity.getGuidHash());
 
        Boolean read_temp = entity.getRead_temp();
        if (read_temp != null) {
            stmt.bindLong(11, read_temp ? 1l: 0l);
        }
 
        Boolean starred_temp = entity.getStarred_temp();
        if (starred_temp != null) {
            stmt.bindLong(12, starred_temp ? 1l: 0l);
        }
 
        java.util.Date lastModified = entity.getLastModified();
        if (lastModified != null) {
            stmt.bindLong(13, lastModified.getTime());
        }
 
        java.util.Date pubDate = entity.getPubDate();
        if (pubDate != null) {
            stmt.bindLong(14, pubDate.getTime());
        }
 
        String enclosureLink = entity.getEnclosureLink();
        if (enclosureLink != null) {
            stmt.bindString(15, enclosureLink);
        }
 
        String enclosureMime = entity.getEnclosureMime();
        if (enclosureMime != null) {
            stmt.bindString(16, enclosureMime);
        }
    }

    @Override
    protected void attachEntity(RssItem entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public RssItem readEntity(Cursor cursor, int offset) {
        RssItem entity = new RssItem( //
            cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // feedId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // link
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // title
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // body
            cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0, // read
            cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0, // starred
            cursor.getString(offset + 7), // author
            cursor.getString(offset + 8), // guid
            cursor.getString(offset + 9), // guidHash
            cursor.isNull(offset + 10) ? null : cursor.getShort(offset + 10) != 0, // read_temp
            cursor.isNull(offset + 11) ? null : cursor.getShort(offset + 11) != 0, // starred_temp
            cursor.isNull(offset + 12) ? null : new java.util.Date(cursor.getLong(offset + 12)), // lastModified
            cursor.isNull(offset + 13) ? null : new java.util.Date(cursor.getLong(offset + 13)), // pubDate
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // enclosureLink
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15) // enclosureMime
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, RssItem entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setFeedId(cursor.getLong(offset + 1));
        entity.setLink(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTitle(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setBody(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setRead(cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0);
        entity.setStarred(cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0);
        entity.setAuthor(cursor.getString(offset + 7));
        entity.setGuid(cursor.getString(offset + 8));
        entity.setGuidHash(cursor.getString(offset + 9));
        entity.setRead_temp(cursor.isNull(offset + 10) ? null : cursor.getShort(offset + 10) != 0);
        entity.setStarred_temp(cursor.isNull(offset + 11) ? null : cursor.getShort(offset + 11) != 0);
        entity.setLastModified(cursor.isNull(offset + 12) ? null : new java.util.Date(cursor.getLong(offset + 12)));
        entity.setPubDate(cursor.isNull(offset + 13) ? null : new java.util.Date(cursor.getLong(offset + 13)));
        entity.setEnclosureLink(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setEnclosureMime(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(RssItem entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(RssItem entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "rssItemList" to-many relationship of Feed. */
    public List<RssItem> _queryFeed_RssItemList(long feedId) {
        synchronized (this) {
            if (feed_RssItemListQuery == null) {
                QueryBuilder<RssItem> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.FeedId.eq(null));
                feed_RssItemListQuery = queryBuilder.build();
            }
        }
        Query<RssItem> query = feed_RssItemListQuery.forCurrentThread();
        query.setParameter(0, feedId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getFeedDao().getAllColumns());
            builder.append(" FROM RSS_ITEM T");
            builder.append(" LEFT JOIN FEED T0 ON T.'FEED_ID'=T0.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected RssItem loadCurrentDeep(Cursor cursor, boolean lock) {
        RssItem entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Feed feed = loadCurrentOther(daoSession.getFeedDao(), cursor, offset);
         if(feed != null) {
            entity.setFeed(feed);
        }

        return entity;    
    }

    public RssItem loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<RssItem> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<RssItem> list = new ArrayList<RssItem>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<RssItem> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<RssItem> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
