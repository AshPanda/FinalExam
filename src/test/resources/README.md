1. Для запуска тестов через терминал сначала предварительно убедитесь что на Вашем компьютере установлена последняя версия MAVEN
2. В терминале введите команду mvn test
3. Запустятся тесты
4. Для запуска формирования отчетов allure, сначала запустите тесты, затем введите в терминале команду allure generate, а затем allure open
5.Actions -> ввод Java, выбераем Java with Maven -> в значении run прописываем
5. run: mvn clean test
6. и закомментировать :
- name: Update dependency graph
 uses: advanced-security/maven-dependency-submission-action@571e99aab1055c2e71a1e2309b9691de18d6b7d6
- нажать Commit Changes