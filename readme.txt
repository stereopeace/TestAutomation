This testcase checks google search.
SearchTests.firstReference checks that first found reference or first ad reference leads to yandex.ru when search name is 'yandex.ru'.

Requirements for test execution:
1. Java 8 and add variable JAVA_HOME.
2. Download maven and add variable M2_HOME.
3. Chrome browser or firefox browser.
4. Add {basedir}/SeleniumDrivers to system variables path.

Steps for test running via cmd prompt:
1. Download project to {basedir}.
2. Open CMD.
3. Move to base directory using command 'cd {basedir}'.
4. Start test execution using command 'mvn -Dtest=SearchTests test'.

Default browser is Firefox.
For Chrome browser change browser name to 'chrome' in src\main\resources\app.properties.
