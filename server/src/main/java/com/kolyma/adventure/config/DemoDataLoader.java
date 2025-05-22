package com.kolyma.adventure.config;

import com.kolyma.adventure.model.Scenario;
import com.kolyma.adventure.model.Scheme;
import com.kolyma.adventure.repository.ScenarioRepository;
import com.kolyma.adventure.repository.SchemeRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DemoDataLoader {

    @Bean
    public CommandLineRunner loadDemoData(
            ScenarioRepository scenarioRepository,
            SchemeRepository schemeRepository
    ) {
        return args -> {
            if (scenarioRepository.count() == 0 && schemeRepository.count() == 0) {

                // Создаём сценарии
                Scenario s1 = new Scenario(null, "Исчезновение шамана",
                        "В уединённой долине пропал известный эвенкийский шаман. Вам предстоит выяснить, что случилось...",
                        "Тайна исчезновения в тайге",
                        "images/pereval.jpg",
                        "Средне");

                Scenario s2 = new Scenario(null, "Тени над Колымой",
                        "На шахте №7 происходят странные события: техника выходит из строя, рабочие исчезают...",
                        "Мистика на севере",
                        "images/prizim.png",
                        "Сложно");

                Scenario s3 = new Scenario(null, "Следы на снегу",
                        "После снежной бури у подножия гор обнаружены странные следы, ведущие в пещеры...",
                        "Ледяной след неизвестного существа",
                        "images/rain.jpg",
                        "Легко");

                List<Scenario> scenarios = List.of(s1, s2, s3);
                scenarioRepository.saveAll(scenarios);

                // Схемы, привязанные к сценариям
                List<Scheme> schemes = List.of(
                        new Scheme(null, s1, "images/preparation/schemes/shemePereval.jpg"),
                        new Scheme(null, s2, "images/preparation/schemes/schemePrizim.jpg"),
                        new Scheme(null, s3, "images/preparation/schemes/schemeRain.jpg")
                );
                schemeRepository.saveAll(schemes);

                System.out.println("✅ Демо-данные успешно загружены!");
            } else {
                System.out.println("ℹ️ Данные уже существуют, загрузка не требуется.");
            }
        };
    }
}