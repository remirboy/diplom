<!DOCTYPE html>
<#import "spring.ftl" as spring />

<title>Генерация Page Object</title>
<meta charset="utf-8">
<#--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">-->
<#--<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>-->
<#--<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>-->
<#--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script> &ndash;&gt;-->
<script src="../static/addNewHTMLElement.js"></script>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
</head>
<body>
<div class="main">
    <form action="/test/testSuite/create" method="post">
        <div class="page_name">
            <label>Название Тест-сьюта<@spring.formInput "testSuiteDTO.name"/></label>
        </div>
        <div class="pages_elements">
                <label>Тест-кейс 1<input name="tests[0].name"></label>
                <ul>
                    <li><label>Проверка 1<input name="tests[0].checks[0]"></label></li>
                    <li><label>Проверка 2<input name="tests[0].checks[1]"></label></li>
                    <li><label>Проверка 3<input name="tests[0].checks[2]"></label></li>
                    <button id="addNewElement" onclick="addNewWebElementInPage()">+</button>

                </ul>

                <label>Тест-кейс 2<input name="tests[1].name"></label>

                <ul>
                    <li><label>Проверка 1<input name="tests[1].checks[0]"></label></li>

                    <li><label>Проверка 2<input name="tests[1].checks[1]"></label></li>

                    <li><label>Проверка 3<input name="tests[1].checks[2]"></label></li>
                    <button id="addNewElement" onclick="addNewWebElementInPage()">+</button>

                </ul>
            </div>
            <button id="addNewElement" onclick="addNewWebElementInPage()">+</button>
            <button>Сгенерировать тест</button>
        </div>
    </form>
</div>
</body>
</html>