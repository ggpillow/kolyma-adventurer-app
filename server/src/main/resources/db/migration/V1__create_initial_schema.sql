-- Таблица сценариев --
CREATE TABLE scenarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    start_descr TEXT,
    mini_description TEXT,
    image_url TEXT,
    difficulty TEXT NOT NULL
);

-- Таблица схем --
CREATE TABLE schemes (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    scenario_id INTEGER NOT NULL,
    image_schemes TEXT NOT NULL,
    FOREIGN KEY(scenario_id) REFERENCES scenarios(id)
);

-- Таблица эпиграфов --
CREATE TABLE epigraphs (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    quote TEXT NOT NULL
);

-- Таблица абзацев --
CREATE TABLE paragraphs (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    paragraph_number INTEGER NOT NULL,
    paragraph_descr TEXT NOT NULL
);

-- Таблица концовок --
CREATE TABLE endings (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title_ending TEXT NOT NULL,
    end_descr TEXT NOT NULL,
    alt_question TEXT,
    scenario_id INTEGER NOT NULL,
    FOREIGN KEY (scenario_id) REFERENCES scenarios(id)
);

-- Таблица ресурсов
CREATE TABLE resources (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL UNIQUE
);

-- Таблица комбинаций предметов
CREATE TABLE item_combinations (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    resource1_id INTEGER NOT NULL,
    resource2_id INTEGER NOT NULL,
    result_item TEXT NOT NULL,
    FOREIGN KEY(resource1_id) REFERENCES resources(id),
    FOREIGN KEY(resource2_id) REFERENCES resources(id)
);
