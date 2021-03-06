Отделы и Сотрудники
========================= 
# Введение 
Требуется создать рабочий прототип Web приложения для работы с отделами и их сотрудниками. 
Web - приложение должно позволять:
* посмотреть список отделов и среднюю зарплату (рассчитывается автоматически) по этим отделам (первая списочная форма);
* список сотрудников в отделах с указанием зарплаты для каждого сотрудника и полем поиска для поиска сотрудников родившихся в определенную дату или в период между датами (вторая списочная форма);
* изменять (добавлять/редактировать/удалять) вышеуказанные данные.

# 1. Отделы 
### 1.1 Просмотр списка отделов: 
Данный режим программы предназначен для просмотра списка отделов. 

##### Основной сценарий: 
* Пользователь выбирает пункт меню "Отдел". 
* Отображается списочная форма просмотра списка всех Отделов. 

![department-list.png](https://www.dropbox.com/s/8yczyk05e9fnmp8/department-list.png?dl=0&raw=1)  
Рисунок 1.1 Просмотр списка Отделов 

В списке отображаются следующие колонки: 
* Отделы - наименование отдела;
* Средняя зарплата - средняя зарплата по отделуж

### 1.2 Добавления Отдела 
##### Основной сценарий: 
* Пользователь, находясь в режиме просмотра списка отделов, нажимает кнопку "Добавить новый отдел"; 
* Отображается форма добавления нового отдела; 
* Пользователь вводит данные и нажимает кнопку "Сохранить"; 
* Если данные введены не корректно, то пользователю отображается соответствующее сообщение; 
* Если данные корректны, то отдел добавляется в базу данных; 
* Если произошла ошибка сохранения данных, то выводится сообщение об ошибке; 
* Если отдел успешно добавлена, то открывается форма просмотра списка отдела с обновленными данными. 

##### Сценарий отмены изменений: 
* Пользователь, находясь в режиме просмотра списка отделов нажимает кнопку "Добавить новый отдел"; 
* Отображается форма добавления отдела; 
* Пользователь вводит данные и нажимает кнопку "Назад"; 
* Данные не сохраняются в базу данных и открывается форма просмотра списка отделов с обновлёнными данными.  

![add_department.png](https://www.dropbox.com/s/u5y2p6dvawpp14j/add_department.png?dl=0&raw=1)    
Рисунок 1.2 - Добавление отдела 

При добавлении отдела вводятся следующие реквизиты: 
* Наименование отдела; 

### 1.3 Редактирование отдела 
##### Основной сценарий: 
* Пользователь, находясь в режиме просмотра списка отделов, нажимает кнопку "Редактировать" в строке выбранного отдела; 
* Отображается форма редактирования; 
* Пользователь изменяет данные и нажимает кнопку "Сохранить"; 
* Если данные введены не корректно, то пользователю отображается соответствующее сообщение; 
* Если данные корректны, то происходит обновление в базе данных; 
* Если произошла ошибка сохранения данных, то выводится сообщение об ошибке; 
* Если отдел успешно изменен, то открывается форма просмотра списка отделов с обновленными данными. 

##### Сценарий отмены изменений: 
* Пользователь, находясь в режиме просмотра списка отделов, нажимает кнопку "Редактировать" в строке выбранного отдела; 
* Отображается форма редактирования отдела; 
* Пользователь вводит данные и нажимает кнопку "Назад"; 
* Данные не сохраняются в базу данных и открывается форма просмотра списка отделов с обновлёнными данными.  

![edit-department.png](https://www.dropbox.com/s/e5ugk6vhqzfj6fl/edit-department.png?dl=0&raw=1)  
1.3 Редактирование отдела 

##### Ограничение данных: 
Название отдела - содержит не более 32 символов. Значение должно быть уникальным в базе данных. 

### 1.4 Удаление отдела 
##### Основной сценарий: 
* Пользователь, находясь в режиме просмотра списка отделов, нажимает кнопку "Удалить" в строке выбранного отдела; 
* Отображается диалоговое окно; 
* Пользователь нажимает кнопку "Да"; 
* Происходит удаление отдела в базе данных; 
* Если произошла ошибка при удалении, то выводится соответствующее сообщение; 
* Если отдел удален успешно, то открывается форма просмотра отделов с обновлёнными данными. 

##### Сценарий отмены удаления: 
* Пользователь, находясь в режиме просмотра списка отделов нажимает кнопку "Удалить" в строке выбранного отдела; 
* Отображается диалоговое окно; 
* Пользователь нажимает кнопку "Нет"; 
* Открывается форма просмотра отделов с обновлёнными данными.  

![delete-department.png](https://www.dropbox.com/s/i0blzqwzu6o4fog/delete-department.png?dl=0&raw=1)
1.4 Подтверждение удаления отдела 

# 2.Сотрудники 
### 2.1 Просмотр списка сотрудников 
##### Основной сценарий 
* Пользователь выбирает пункт меню "Сотрудники"; 
* Отображается форма просмотра списка всех сотрудников.  

![list-employee.png](https://www.dropbox.com/s/4an2jsaf15qb5fr/list-employee.png?dl=0&raw=1)  
2.1 Список всех сотрудников 

В списке отображаются следующие колонки:
* Номер отдела - номер отдела сотрудника 
* ФИО сотрудника - полное имя сотрудника
* Зарплата - харплата сотрудника;

##### Фильтрация 
Для поиска сотрудников родившихся в определенную дату или в период между датами предусмотрена возможность выбора периода отбора данных с и по. 
Если данные не введены, то фильтрация не осуществляется. 
По умолчания показываются все сотрудники 
Если выбраны оба фильтра, то список сотрудников будет создаваться на основе объединения правил фильтрации обоих фильтров. 
Если выбраны один фильтра, то список сотрудников будет создаваться на основе объединения правил фильтрации одного фильтра. 
Обновление данных после выбора способа фильтрации осуществляется нажатием кнопки "Обновить". 

### 2.2 Добавление сотрудника 
##### Основной сценарий: 
* Пользователь, находясь в режиме просмотра списка сотрудников, нажимает кнопку "Добавить"; 
* Отображается форма добавления нового сотрудника; 
* Пользователь вводит данные и нажимает "Сохранить"; 
* Если данные введены не корректно, то пользователю отображается соответствующее сообщение; 
* Если данные корректны, то сотрудника добавляется в базу данных; 
* Если произошла ошибка сохранения данных, то выводится сообщение об ошибке; 
* Если сотрудника успешно добавлен, то открывается форма просмотра списка сотрудников с обновленными данными. 

##### Ограничение данных: 
ФИО сотрудника - содержит не более 100 символов.

##### Сценарий отмены изменений: 
* Пользователь, находясь в режиме просмотра списка сотрудников, нажимает кнопку "Добавить"; 
* Отображается форма добавления сотрудника; 
* Пользователь вводит данные и нажимает кнопку "Назад"; 
* Данные не сохраняются в базу данных и открывается форма просмотра списка сотрудников с обновлёнными данными. 

![add_employee.png](https://www.dropbox.com/s/pwnzfike05eee95/add_employee.png?dl=0&raw=1)  
2.2 Форма добавления сотрудника 

При добавлении сотрудника вводятся следующие реквизиты: 
* Отдел - выбор отдела;
* ФИО сотрудника - полное имя сотрудника; 
* Дата рождения - дата рождения сотрудника;
* Зарплата - зарплата сотрудника;

### 2.3 Редактирование сотрудника 
##### Основной сценарий: 
* Пользователь, находясь в режиме просмотра списка сотрудников, нажимает кнопку "Редактировать" в строке выбранного сотрудника; 
* Отображается форма редактирование; 
* Пользователь изменяет данные и нажимает кнопку "Изменить"; 
* Если данные введены не корректно, то пользователю отображается соответствующее сообщение; 
* Если данные корректны, то происходит обновление в базе данных; 
* Если произошла ошибка сохранения данных, то выводится сообщение об ошибке; 
* Если сотрудник успешно обновлён, то открывается форма просмотра списка сотрудников с обновленными данными. 

##### Сценарий отмены изменений: 
* Пользователь, находясь в режиме просмотра списка сотрудников, нажимает кнопку "Редактировать" встроке выбранного сотрудника; 
* Отображается форма редактирования сотрудника; 
* Пользователь вводит данные и нажимает кнопку "Назад"; 
* Данные не сохраняются в базу данных и открывается форма просмотра списка сотрудников с обновлёнными данными.

![edit_employee.png](https://www.dropbox.com/s/ww3j4a2wsyrx21t/edit_employee.png?dl=0&raw=1)  
2.3 Редактирование сотрудника 

При редактировании сотрудника вводятся следующие реквизиты: 
* Отдел - выбор отдела;
* ФИО сотрудника - полное имя сотрудника; 
* Дата рождения - дата рождения сотрудника;
* Зарплата - зарплата сотрудника;

### 2.4 Удаление сотрудника 
##### Основной сценарий: 
* Пользователь, находясь в режиме просмотра списка сотрудников, нажимает кнопку "Удалить" в строке выбранного сотрудника; 
* Отображается диалог подтверждения на удаление; 
* Пользователь нажимает кнопку "Да"; 
* Происходит удаление сотрудника в базе данных; 
* Если произошла ошибка при удалении, то выводится соответствующее сообщение; 
* Если сотрудник удалён успешно, то открывается форма просмотра сотрудников с обновлёнными данными. 

##### Сценарий отмены удаления: 
* Пользователь, находясь в режиме просмотра списка сотрудников, нажимает кнопку "Удалить" в строке выбранного сотрудника; 
* Отображается диалоговое окно; 
* Пользователь нажимает кнопку "Нет"; 
* Открывается форма просмотра сотрудников с обновлёнными данными.  

![delete_employee.png](https://www.dropbox.com/s/n5wqupimy863n80/delete_employee.png?dl=0&raw=1)  
2.4 Подтверждение удаления сотрудника 