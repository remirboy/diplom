function addNewAttributeInModel() {

    event.preventDefault();

    addNewAttributeButton = document.querySelector('#addNewAttribute');
    putDiv = document.querySelector('.models_variables');

    newAttributeDiv = document.createElement("div")
    newAttributeDiv.setAttribute('class','models_variables_attributes')

    elemType = document.createElement("label");
    elemType.innerHTML = "Тип атрибута модели"

    elemSelect = document.createElement("select");
    elemSelect.setAttribute('name', 'variable_type');
    
    elemIntOption = document.createElement("option");
    elemIntOption.innerHTML = "Int"

    elemFloatOption = document.createElement("option");
    elemFloatOption.innerHTML = "Float"
    
    elemStringOption = document.createElement("option");
    elemStringOption.innerHTML = "String"

    elemBooleanOption = document.createElement("option");
    elemBooleanOption.innerHTML = "Boolean"

    elemIntOption.setAttribute('name', 'variable_type_int');
    elemFloatOption.setAttribute('name', 'variable_type_float');
    elemStringOption.setAttribute('name', 'variable_type_string');
    elemBooleanOption.setAttribute('name', 'variable_type_boolean');

    elemSelect.appendChild(elemIntOption);
    elemSelect.appendChild(elemFloatOption);
    elemSelect.appendChild(elemStringOption);
    elemSelect.appendChild(elemBooleanOption);

    elemType.appendChild(elemSelect);

    elemName = document.createElement("label");
    elemName.innerHTML = "Имя атрибута"

    elemNameInput = document.createElement("input");
    elemNameInput.setAttribute('name', 'variable_name')

    elemName.appendChild(elemNameInput);

    newAttributeDiv.appendChild(elemType);
    newAttributeDiv.appendChild(elemName);

    putDiv.insertBefore(newAttributeDiv,addNewAttributeButton);
 
}





function addNewWebElementInPage() {

    event.preventDefault();

    addNewWebElementButton = document.querySelector('#addNewElement');
    putDiv = document.querySelector('.pages_elements');

    newElementDiv = document.createElement("div")
    newElementDiv.setAttribute('class','page_element')

    elemLocatorType = document.createElement("label");
    elemLocatorType.innerHTML = "Тип локатора"

    elemSelect = document.createElement("select");
    elemSelect.setAttribute('name', 'page_element_locator');
    
    elemIdOption = document.createElement("option");
    elemIdOption.innerHTML = "id"

    elemNameOption = document.createElement("option");
    elemNameOption.innerHTML = "name"
    
    elemClassNameOption = document.createElement("option");
    elemClassNameOption.innerHTML = "className"

    elemTagNameOption = document.createElement("option");
    elemTagNameOption.innerHTML = "TagName"
    
    elemLinkTextOption = document.createElement("option");
    elemLinkTextOption.innerHTML = "LinkText"

    elemPartialLinkTextOption = document.createElement("option");
    elemPartialLinkTextOption.innerHTML = "PartialLinkText"

    elemCSSOption = document.createElement("option");
    elemCSSOption.innerHTML = "cssSelector"

    elemXPathOption = document.createElement("option");
    elemXPathOption.innerHTML = "xPath"

    elemIdOption.setAttribute('name', 'page_element_locator_id');
    elemNameOption.setAttribute('name', 'page_element_locator_name');
    elemClassNameOption.setAttribute('name', 'page_element_locator_class');
    elemTagNameOption.setAttribute('name', 'page_element_locator_tag');
    elemLinkTextOption.setAttribute('name', 'page_element_locator_link');
    elemPartialLinkTextOption.setAttribute('name', 'page_element_locator_partial');
    elemCSSOption.setAttribute('name', 'page_element_locator_css');
    elemXPathOption.setAttribute('name', 'page_element_locator_xpath');



    elemSelect.appendChild(elemIdOption);
    elemSelect.appendChild(elemNameOption);
    elemSelect.appendChild(elemClassNameOption);
    elemSelect.appendChild(elemTagNameOption);
    elemSelect.appendChild(elemLinkTextOption);
    elemSelect.appendChild(elemPartialLinkTextOption);
    elemSelect.appendChild(elemCSSOption);
    elemSelect.appendChild(elemXPathOption);

    elemLocatorType.appendChild(elemSelect);

    elemWebElementType = document.createElement("label");
    elemWebElementType.innerHTML = "Тип веб-элемента"

    elemWebElementSelect = document.createElement("select");
    elemWebElementSelect.setAttribute('name', 'page_element_type');
    
    elemButtonOption = document.createElement("option");
    elemButtonOption.innerHTML = "Button"

    elemTextOption = document.createElement("option");
    elemTextOption.innerHTML = "Text"
    
    elemInputOption = document.createElement("option");
    elemInputOption.innerHTML = "Input"

    elemButtonOption.setAttribute('name', 'page_element_type_button');
    elemTextOption.setAttribute('name', 'page_element_type_text');
    elemInputOption.setAttribute('name', 'page_element_type_input');

    elemWebElementSelect.appendChild(elemButtonOption);
    elemWebElementSelect.appendChild(elemTextOption);
    elemWebElementSelect.appendChild(elemInputOption);

    elemWebElementType.appendChild(elemWebElementSelect);

    elemWebElementName = document.createElement("label");
    elemWebElementName.innerHTML = "Локатор"

    elemWebElementNameInput = document.createElement("input");
    elemWebElementNameInput.setAttribute('name', 'page_element_locator_name')

    elemWebElementName.appendChild(elemWebElementNameInput);

    newElementDiv.appendChild(elemLocatorType);
    newElementDiv.appendChild(elemWebElementType);
    newElementDiv.appendChild(elemWebElementName);

    putDiv.insertBefore(newElementDiv,addNewWebElementButton);
    //   addNewAttributeButton = document.querySelector('#addNewAttribute');
    // document.insertBefore(newAttributeDiv, addNewAttributeButton);
 
}