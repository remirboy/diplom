<!DOCTYPE html>
<#import "spring.ftl" as spring />

<title>Генерация Page Object</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script> -->
    <script src="../static/addNewHTMLElement.js"></script>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
</head>
<body>
<div class="main">
    <form action="/pageObject/pageGeneration/create" method="post">
    <div class="page_name">
        <label>Название PageObject<@spring.formInput "pageObjectDTO.name"/></label>
    </div>
    <div class="pages_elements">
            <div class="page_element">
                    <label> Тип локатора
                    <select name="page_element_locator">
                    <option name="variable_type">id</option>
                    <option name="variable_type">name</option>
                    <option name="variable_type">className</option>
                    <option name="variable_type">TagName</option>
                    <option name="variable_type">LinkText</option>
                    <option name="variable_type">PartialLinkText</option>
                    <option name="variable_type">cssSelector</option>
                    <option name="variable_type">xPath</option>
                </select>
                </label> 
                <label> Тип веб-элемента
                    <select name="page_element_locator">
                    <option name="variable_type">Button</option>    <!-- Сlick методы -->
                    <option name="variable_type">text</option>           <!-- Нужно будет send keys clear методы -->
                    <option name="variable_type">Input</option>     <!-- Нужно будет send keys clear методы -->
                    <!-- Нужно будет send keys clear методы -->
                </select>
                </label> 
                <label>Локатор<input name="variable_name"></label>
                <label>Имя веб-элемента<input name="variable_name"></label>

            </div>
            <div class="page_element">
                <label> Тип локатора
                <select name="page_element_locator">
                <option name="variable_type">id</option>
                <option name="variable_type">name</option>
                <option name="variable_type">className</option>
                <option name="variable_type">TagName</option>
                <option name="variable_type">LinkText</option>
                <option name="variable_type">PartialLinkText</option>
                <option name="variable_type">cssSelector</option>
                <option name="variable_type">xPath</option>
            </select>
            </label> 
            <label> Тип веб-элемента
                <select name="page_element_locator">
                <option name="variable_type">Button</option>    <!-- Сlick методы -->
                <option name="variable_type">text</option>           <!-- Нужно будет send keys clear методы -->
                <option name="variable_type">Input</option>     <!-- Нужно будет send keys clear методы -->
                <!-- Нужно будет send keys clear методы -->
            </select>
            </label> 
            <label>Локатор<input name="variable_name"></label>
                <label>Имя веб-элемента<input name="variable_name"></label>

            </div>
        <div class="page_element">
            <label> Тип локатора
            <select name="page_element_locator">
            <option name="variable_type">id</option>
            <option name="variable_type">name</option>
            <option name="variable_type">className</option>
            <option name="variable_type">TagName</option>
            <option name="variable_type">LinkText</option>
            <option name="variable_type">PartialLinkText</option>
            <option name="variable_type">cssSelector</option>
            <option name="variable_type">xPath</option>
        </select>
        </label> 
        <label> Тип веб-элемента
            <select name="page_element_locator">
            <option name="variable_type">Button</option>    <!-- Сlick методы -->
            <option name="variable_type">text</option>           <!-- Нужно будет send keys clear методы -->
            <option name="variable_type">Input</option>     <!-- Нужно будет send keys clear методы -->
            <!-- Нужно будет send keys clear методы -->
        </select>
        </label> 
        <label>Локатор<input name="variable_name"></label>
        <label>Имя веб-элемента<input name="variable_name"></label>

        </div>
        <button id="addNewElement" onclick="addNewWebElementInPage()">+</button>
        <button>Сгенерировать страницу</button>

    </div>

    </form>
</div>
</body>
</html>