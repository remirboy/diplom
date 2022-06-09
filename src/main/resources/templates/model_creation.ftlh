<!DOCTYPE html>
<#import "spring.ftl" as spring />

<title>Генерация модели</title>
<meta charset="utf-8">
<!-- <link rel="stylesheet" href="../static/Mainpage.css">
<link rel="stylesheet" type="text/css" href="../static/navigation.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script> -->
<script src="../static/addNewHTMLElement.js"></script>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
</head>
<body>
<div class="main">
    <form action="/model/modelGeneration/create" method="post">
        <div class="model_name">
            <label> Название модели<@spring.formInput "modelDTO.name"/></label>
        </div>
        <div class="models_variables">
            <#list attributes as attributes>

            <div class="models_variables_attributes">


                    <label> Тип атрибута модели
                        <select name="attributes[${attributes?index}].type">
                            <option name="variable_type_int">Int</option>
                            <option name="variable_type_float">Float</option>
                            <option name="variable_type_string">String</option>
                            <option name="variable_type_boolean">Boolean</option>
                        </select>

                    </label>
                    <label><input name="attributes[${attributes?index}].name"></label>

            </div>
            </#list>
        </div>
        <#--<div class="models_variables_attributes">
            <label> Тип атрибута модели

                <select name="variable_type">
                    <option name="variable_type_int">Int</option>
                    <option name="variable_type_float">Float</option>
                    <option name="variable_type_string">String</option>
                    <option name="variable_type_boolean">Boolean</option>
                </select>
            </label>

        </div>

        <div class="models_variables_attributes">&ndash;&gt;
            <label> Тип атрибута модели
                <select name="variable_type">
                    <option name="variable_type_int">Int</option>
                    <option name="variable_type_float">Float</option>
                    <option name="variable_type_string">String</option>
                    <option name="variable_type_boolean">Boolean</option>
                </select>
            </label>
            <label>Имя атрибута<@spring.formInput "attribute.name"/></label>
        </div>-->

        <button type="submit" >Сгенерировать модель</button>
</div>
</form>
<div style="display: flex">
    <form style="margin-right: 3px" action="/attribute/add" method="post">
        <input type="submit" value="+">
    </form>
    <form action="/attribute/delete" method="post">
        <input type="submit" value="-"></form>
</div>
</div>
</body>
</html>