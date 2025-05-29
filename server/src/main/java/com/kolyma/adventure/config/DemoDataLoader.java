
package com.kolyma.adventure.config;

import com.kolyma.adventure.model.*;
import com.kolyma.adventure.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DemoDataLoader {

    @Bean
    public CommandLineRunner loadDemoData(
            ScenarioRepository scenarioRepository,
            SchemeRepository schemeRepository,
            EpigraphRepository epigraphRepository,
            ParagraphRepository paragraphRepository,
            EndingRepository endingRepository
    ) {
        return args -> {
            if (scenarioRepository.count() == 0 && schemeRepository.count() == 0) {

                // Создаём сценарии
                Scenario s1 = new Scenario(null, "Исчезновение шамана",
                        "В уединённой долине пропал известный эвенкийский шаман. Вам предстоит выяснить, что случилось...",
                        "Тайна исчезновения в тайге",
                        "images/scenarios/pereval.jpg",
                        "Средне");

                Scenario s2 = new Scenario(null, "Тени над Колымой",
                        "На шахте №7 происходят странные события: техника выходит из строя, рабочие исчезают...",
                        "Мистика на севере",
                        "images/scenarios/prizim.png",
                        "Сложно");

                Scenario s3 = new Scenario(null, "Следы на снегу",
                        "После снежной бури у подножия гор обнаружены странные следы, ведущие в пещеры...",
                        "Ледяной след неизвестного существа",
                        "images/scenarios/rain.jpg",
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

                // Эпиграфы (как было ранее)
                if (epigraphRepository.count() == 0) {
                    List<Epigraph> epigraphs = List.of(
                            new Epigraph(null, "Когда идёшь по тайге — слушай молча, иначе не услышишь шёпот духов.", "images/epigraphs/ep1.jpg")
                            // ... остальные ...
                    );
                    epigraphRepository.saveAll(epigraphs);
                    System.out.println("✅ Эпиграфы успешно загружены!");
                }

                // Абзацы
                if (paragraphRepository.count() == 0) {
                    List<Paragraph> paragraphs = List.of(
                            new Paragraph(null, 1, "Вы просыпаетесь у костра, вокруг глухая тайга."),
                            new Paragraph(null, 2, "Перед вами развилка: налево — бурелом, направо — следы."),
                            new Paragraph(null, 3, "Вы слышите треск веток. Кто-то или что-то приближается...")
                    );
                    paragraphRepository.saveAll(paragraphs);
                    System.out.println("✅ Абзацы успешно загружены!");
                }

                // Концовки
                if (endingRepository.count() == 0) {
                    List<Ending> endings = List.of(
                            new Ending(null, "Спаслись все",
                                    "Вы выбрались из тайги с минимальными потерями. Победа — в том, что вы остались людьми.", s1),
                            new Ending(null, "Кто-то из нас пал",
                                    "Некоторые пожертвовали собой ради спасения остальных. Это было нелегко.", s1),
                            new Ending(null, "Я остался один",
                                    "Вы дошли до финиша, но один. Никто больше не вернулся из тайги.", s1),
                            new Ending(null, "Альтернативная концовка",
                                    "В пути мы избавились от лишнего рта. Теперь стало легче... и страшнее.", s1)
                    );
                    endingRepository.saveAll(endings);
                    System.out.println("✅ Концовки успешно загружены!");
                }

                System.out.println("✅ Демо-данные успешно загружены!");
            } else {
                System.out.println("ℹ️ Данные уже существуют, загрузка не требуется.");
            }
        };
    }
}