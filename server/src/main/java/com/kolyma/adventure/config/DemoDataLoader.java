package com.kolyma.adventure.config;

import com.kolyma.adventure.model.Epigraph;
import com.kolyma.adventure.model.Paragraph;
import com.kolyma.adventure.model.Scenario;
import com.kolyma.adventure.model.Scheme;
import com.kolyma.adventure.repository.EpigraphRepository;
import com.kolyma.adventure.repository.ParagraphRepository;
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
            SchemeRepository schemeRepository,
            EpigraphRepository epigraphRepository,
            ParagraphRepository paragraphRepository
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

                if (epigraphRepository.count() == 0) {
                    List<Epigraph> epigraphs = List.of(
                            new Epigraph(null, "Когда идёшь по тайге — слушай молча, иначе не услышишь шёпот духов.", "images/epigraphs/ep1.jpg"),
                            new Epigraph(null, "Сквозь пургу и страх рождаются легенды.", "images/epigraphs/ep2.jpg"),
                            new Epigraph(null, "Каждый след в снегу — это след чьей-то судьбы.", "images/epigraphs/ep3.jpg"),
                            new Epigraph(null, "Не все, кто ушёл в лес, хотят, чтобы их нашли.", "images/epigraphs/ep4.jpg"),
                            new Epigraph(null, "Глубже темноты только тишина.", "images/epigraphs/ep5.jpg"),
                            new Epigraph(null, "Если ты слышишь шаги позади, но никого не видишь — не оборачивайся.", "images/epigraphs/ep6.jpg"),
                            new Epigraph(null, "Знание тропы — ещё не гарантия возврата.", "images/epigraphs/ep7.jpg"),
                            new Epigraph(null, "Настоящая опасность не оставляет следов.", "images/epigraphs/ep8.jpg"),
                            new Epigraph(null, "Иногда природа лишь делает вид, что безобидна.", "images/epigraphs/ep9.jpg"),
                            new Epigraph(null, "У костра ты не один, если лес наблюдает.", "images/epigraphs/ep10.jpg"),
                            new Epigraph(null, "Холод проверяет не только тело, но и дух.", "images/epigraphs/ep11.jpg"),
                            new Epigraph(null, "Тропа исчезает тогда, когда ты теряешь веру.", "images/epigraphs/ep12.jpg"),
                            new Epigraph(null, "Иногда карта не может показать того, что не принадлежит миру людей.", "images/epigraphs/ep13.jpg"),
                            new Epigraph(null, "Тьма в пещере — не самая страшная, когда ты не один.", "images/epigraphs/ep14.jpg"),
                            new Epigraph(null, "Если звери молчат — значит, кто-то говорит громче.", "images/epigraphs/ep15.jpg"),
                            new Epigraph(null, "Ночью даже деревья шепчутся.", "images/epigraphs/ep16.jpg"),
                            new Epigraph(null, "Выживание — это искусство тишины.", "images/epigraphs/ep17.jpg"),
                            new Epigraph(null, "Следы могут вести к правде, а могут — к ловушке.", "images/epigraphs/ep18.jpg"),
                            new Epigraph(null, "Границы мира заканчиваются там, где начинается тайга.", "images/epigraphs/ep19.jpg"),
                            new Epigraph(null, "Лес знает больше, чем хочет рассказать.", "images/epigraphs/ep20.jpg")
                    );
                    epigraphRepository.saveAll(epigraphs);
                    System.out.println("✅ Эпиграфы успешно загружены!");
                } else {
                    System.out.println("ℹ️ Эпиграфы уже существуют.");
                }

                // абзацы
                if (paragraphRepository.count() == 0) {
                    List<Paragraph> paragraphs = List.of(
                            new Paragraph(null, 1, "Вы просыпаетесь у костра, вокруг глухая тайга."),
                            new Paragraph(null, 2, "Перед вами развилка: налево — бурелом, направо — следы."),
                            new Paragraph(null, 3, "Вы слышите треск веток. Кто-то или что-то приближается...")
                            // ... добавь больше при необходимости ...
                    );
                    paragraphRepository.saveAll(paragraphs);
                    System.out.println("✅ Абзацы успешно загружены!");
                }


                System.out.println("✅ Демо-данные успешно загружены!");
            } else {
                System.out.println("ℹ️ Данные уже существуют, загрузка не требуется.");
            }
        };
    }
}