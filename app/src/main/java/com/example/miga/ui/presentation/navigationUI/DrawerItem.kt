package com.example.miga.ui.presentation.navigationUI

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

enum class DrawerScreens(val title: String, val route: String, val icon: ImageVector) {
    Currency("Главная", "Currency", Icons.Default.Home),
    Account("Забронировать сумму/курс", "account", Icons.Default.Face),
    GoldBars("Золотые слитки НБ РК", "account", Icons.Default.Face),
    NearestPoints("Ближайшие пункты", "account", Icons.Default.LocationOn),
    FinancialNewsAndAnalytics("Финансовые новости и аналитика", "account", Icons.Default.Face),
    ArchiveOfCourses("Архив курсов", "account", Icons.Default.Face),
    CoursesOfTheNB("Курсы НацБанка РК", "account", Icons.Default.Face),
    LoginRegistration("Вход/Регистрация", "account", Icons.Default.Refresh),
    AboutTheCompany("О Компании", "account", Icons.Default.Info),
    HowToFindUs("Как нас найти?", "account", Icons.Default.Search),
    InformationForClients("Информация для клиентов", "account", Icons.Default.Warning),
    GetADiscount("Получить скидку %", "account", Icons.Default.ThumbUp),
    Notifications("Уведомления", "account", Icons.Default.Face),
    ReviewsAndSuggestions("Отзывы и предложения", "account", Icons.Default.Face),
    Vacancy("Вакансии", "account", Icons.Default.MoreVert),
    Agreement("Соглашение", "account", Icons.Default.Face),
    Share("Поделиться", "account", Icons.Default.Share);
}

internal val screens = listOf(
    DrawerScreens.Currency,
    DrawerScreens.Account,
    DrawerScreens.GoldBars,
    DrawerScreens.NearestPoints,
    DrawerScreens.FinancialNewsAndAnalytics,
    DrawerScreens.ArchiveOfCourses,
    DrawerScreens.CoursesOfTheNB,
    DrawerScreens.LoginRegistration,
    DrawerScreens.AboutTheCompany,
    DrawerScreens.HowToFindUs,
    DrawerScreens.InformationForClients,
    DrawerScreens.GetADiscount,
    DrawerScreens.Notifications,
    DrawerScreens.ReviewsAndSuggestions,
    DrawerScreens.Vacancy,
    DrawerScreens.Agreement,
    DrawerScreens.Share
)