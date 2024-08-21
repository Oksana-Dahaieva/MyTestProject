pipeline {
    agent any  // Использует любой доступный агент

    stages {
        stage('Checkout') {
            steps {
                // Проверка кода из репозитория
                git 'https://github.com/Oksana-Dahaieva/MyTestProject.git'
            }
        }
//        stage('Build') {
//            steps {
//                // Сборка проекта с помощью Maven
//                sh 'mvn clean install'
//            }
//        }
        stage('Run Tests') {
            steps {
                // Запуск тестов с помощью Maven, указание класса раннера
                sh 'mvn -Dtest=Runner test'
            }
        }
        stage('Allure Report') {
            steps {
                // Генерация отчета Allure
                sh 'mvn allure:report'
            }
            post {
                always {
                    // Публикация отчета Allure как артефакт
                    allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
                }
            }
        }
    }

    post {
        success {
            // Успешное выполнение пайплайна
            echo 'Pipeline completed successfully!'
        }
        failure {
            // Неудачное выполнение пайплайна
            echo 'Pipeline failed!'
        }
    }
}