CREATE TABLE IF NOT EXISTS `Song` (`song_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL COLLATE NOCASE);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Song_name` ON `${TABLE_NAME}` (`name`);

CREATE TABLE IF NOT EXISTS `Sample` (`sample_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `content` TEXT NOT NULL, `length` INTEGER NOT NULL);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Sample_name` ON `${TABLE_NAME}` (`name`);

CREATE TABLE IF NOT EXISTS `Playlist` (`playlist_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL COLLATE NOCASE);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Playlist_name` ON `${TABLE_NAME}` (`name`);

CREATE TABLE IF NOT EXISTS `SongPlaylist` (`song_playlist_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `song_id` INTEGER NOT NULL, `playlist_id` INTEGER NOT NULL, `sequence` INTEGER NOT NULL, FOREIGN KEY(`song_id`) REFERENCES `Song`(`song_id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`playlist_id`) REFERENCES `Playlist`(`playlist_id`) ON UPDATE NO ACTION ON DELETE CASCADE );

CREATE INDEX IF NOT EXISTS `index_SongPlaylist_playlist_id_sequence` ON `${TABLE_NAME}` (`playlist_id`, `sequence`);

CREATE UNIQUE INDEX IF NOT EXISTS `index_SongPlaylist_playlist_id_song_id` ON `${TABLE_NAME}` (`playlist_id`, `song_id`);

CREATE INDEX IF NOT EXISTS `index_SongPlaylist_song_id` ON `${TABLE_NAME}` (`song_id`);

CREATE INDEX IF NOT EXISTS `index_SongPlaylist_playlist_id` ON `${TABLE_NAME}` (`playlist_id`);

CREATE TABLE IF NOT EXISTS `SongSample` (`song_sample_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `song_id` INTEGER NOT NULL, `sample_id` INTEGER NOT NULL, `sequence` INTEGER NOT NULL, `repetitions` INTEGER NOT NULL, FOREIGN KEY(`song_id`) REFERENCES `Song`(`song_id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`sample_id`) REFERENCES `Sample`(`sample_id`) ON UPDATE NO ACTION ON DELETE CASCADE );

CREATE INDEX IF NOT EXISTS `index_SongSample_song_id_sequence` ON `${TABLE_NAME}` (`song_id`, `sequence`);

CREATE INDEX IF NOT EXISTS `index_SongSample_sample_id_sequence_repetitions` ON `${TABLE_NAME}` (`sample_id`, `sequence`, `repetitions`);

CREATE INDEX IF NOT EXISTS `index_SongSample_song_id` ON `${TABLE_NAME}` (`song_id`);

CREATE INDEX IF NOT EXISTS `index_SongSample_sample_id` ON `${TABLE_NAME}` (`sample_id`);





