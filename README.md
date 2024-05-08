### Приветствую тестирующих!
Это моя реализация тестового задания. 
Я приступил к выполнению этой таски в 4:55pm 05/06/2024(UTC+3)

Я решил не делать многомодульное приложение по двум причинам:
1. в ТЗ не было написано, что требуется написать многомодульное приложение
2. в данном проекте дополнительные модули будут лишь обременять. Даже учитывая, что я умею с ними работать, стоит осознавать тот факт, что это приложение с одним-двумя экранами, и я разрабатываю это приложение один. Я могу потратить время на объяснения своих решений, но думаю, что лучше потрачу это время на собеседовании(если пройду).

**UPD: 08/05/2024 9:30pm** -> я закончил с этим приложением. Оно вышло довольно простым, понятно, что идёт проверка на код стайл, знание архитектуры, паттернов и анти-паттернов, а также много чего ещё. Но даже учитывая, что задание должно было быть супер простым, я всё равно сумел налажать. Я потратил всё 07.05.2024 на решение проблемы "Cannot create instance *ViewModel*". В общем, оказалось, что виноват был не код, который я отрефакторил, переписал DI и построчно проверял работоспособность... А моя версия Hilt в libs.versions.toml... Я думал, что проблема была в Generic'ах и JVM байт-коде, типа, граф не может найти вью модель, и я рассматривал под лупой весь процесс кодогенерации)) В общем!!

#### Спасибо команде ВК, за предоставленную возможность протестировать свои силы и возможность пройти на стажировку. Я ценю это!

### Greetings to all testers!
This is my realisation for this task.
I began this project at 4:55pm 05/06/2024(UTC+3)

This app wont be multi-module because of:
1. in tech task theres no a single word about modules.
2. in this project additional modules(data, domain) will be burdensome. I know how to handle them, but I think this is unnecessary to add them.

**UPD: 08/05/2024 9:30pm** -> I finished this app. It turned out to be simple, its alright, because we know that the main purpose of this app is to show programmer's code-style, architecture knowledge, patterns and anti-patterns, and so on... But, anyways, I messed up a little bit. I wasted entire day onto solving "Cannot create instance *ViewModel*". So, it wasnt code problem, that I refactored and rewrote many times... My Hilt version in libs.versions.toms was different with Hilt-Compiler version. I thought problems were Generics and JVM byte-code, like, hilt graph cant find the ViewModel, so I searched through entire DI code-generation.. SO!!

#### Thanks VK Team, for giving me an opportunity to test my own skills and opportunity to get an internship. I appreciate that!
