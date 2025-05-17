CREATE TABLE scenarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    start_descr TEXT,
    mini_description TEXT,
    image_url TEXT,
    difficulty TEXT
);

CREATE TABLE schemes (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    id_scenarios INTEGER NOT NULL,
    image_schemes TEXT NOT NULL,
    FOREIGN KEY(id_scenarios) REFERENCES scenarios(id)
);

CREATE TABLE epigraphs (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    quote TEXT NOT NULL,
    imageEpigraphs TEXT NOT NULL
)