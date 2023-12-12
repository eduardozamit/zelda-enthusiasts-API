CREATE TABLE users (
       id TEXT PRIMARY KEY UNIQUE NOT NULL,
        login TEXT NOT NULL UNIQUE,
         password TEXT NOT NULL,
        age INTEGER NOT NULL,
        role TEXT NOT NULL

);
