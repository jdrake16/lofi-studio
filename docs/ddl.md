## Data Definition Language

```sqlite
CREATE TABLE IF NOT EXISTS `Song`
(
    `song_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`    TEXT                              NOT NULL COLLATE NOCASE
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Song_name` ON `Song` (`name`);

CREATE TABLE IF NOT EXISTS `Sample`
(
    `sample_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`      TEXT                              NOT NULL,
    `content`   TEXT                              NOT NULL,
    `length`    INTEGER                           NOT NULL
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Sample_name` ON `Playlist` (`name`);

CREATE TABLE IF NOT EXISTS `Playlist`
(
    `playlist_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`        TEXT                              NOT NULL COLLATE NOCASE
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Playlist_name` ON `SongPlaylist` (`name`);

CREATE TABLE IF NOT EXISTS `SongPlaylist`
(
    `song_playlist_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `song_id`          INTEGER                           NOT NULL,
    `playlist_id`      INTEGER                           NOT NULL,
    `sequence`         INTEGER                           NOT NULL,
    `name`             int                               not null,
    FOREIGN KEY (`song_id`) REFERENCES `Song` (`song_id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    FOREIGN KEY (`playlist_id`) REFERENCES `Playlist` (`playlist_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_SongPlaylist_playlist_id_sequence` ON `SongPlaylist` (`playlist_id`, `sequence`);

CREATE UNIQUE INDEX IF NOT EXISTS `index_SongPlaylist_playlist_id_song_id` ON `SongPlaylist` (`playlist_id`, `song_id`);

CREATE INDEX IF NOT EXISTS `index_SongPlaylist_song_id` ON `SongPlaylist` (`song_id`);

CREATE INDEX IF NOT EXISTS `index_SongPlaylist_playlist_id` ON `SongPlaylist` (`playlist_id`);

CREATE TABLE IF NOT EXISTS `SongSample`
(
    `song_sample_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `song_id`        INTEGER                           NOT NULL,
    `sample_id`      INTEGER                           NOT NULL,
    `sequence`       INTEGER                           NOT NULL,
    `repetitions`    INTEGER                           NOT NULL,
    FOREIGN KEY (`song_id`) REFERENCES `Song` (`song_id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    FOREIGN KEY (`sample_id`) REFERENCES `Sample` (`sample_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_SongSample_song_id_sequence` ON `SongSample` (`song_id`, `sequence`);

CREATE INDEX IF NOT EXISTS `index_SongSample_sample_id_sequence_repetitions` ON `SongSample` (`sample_id`, `sequence`, `repetitions`);

CREATE INDEX IF NOT EXISTS `index_SongSample_song_id` ON `SongSample` (`song_id`);

CREATE INDEX IF NOT EXISTS `index_SongSample_sample_id` ON `SongSample` (`sample_id`);
```

[`ddl.sql`](sql/ddl.sql)