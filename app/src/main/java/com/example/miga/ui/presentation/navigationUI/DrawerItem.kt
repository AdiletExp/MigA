package com.example.miga.ui.presentation.navigationUI

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerScreens(val title: String, val route: String, val icon: ImageVector) {
    object Currency : DrawerScreens("Главная", "Currency", Icons.Default.Home)
    object Account : DrawerScreens("Забронировать сумму/курс", "account", Icons.Default.Face)
    object GoldBars : DrawerScreens("Золотые слитки НБ РК", "account", Icons.Default.Face)
    object NearestPoints : DrawerScreens("Ближайшие пункты", "account", Icons.Default.LocationOn)
    object FinancialNewsAndAnalytics :
        DrawerScreens("Финансовые новости и аналитика", "account", Icons.Default.Face)

    object ArchiveOfCourses : DrawerScreens("Архив курсов", "account", Icons.Default.Face)
    object CoursesOfTheNB : DrawerScreens("Курсы НацБанка РК", "account", Icons.Default.Face)
    object LoginRegistration : DrawerScreens("Вход/Регистрация", "account", Icons.Default.Refresh)
    object AboutTheCompany : DrawerScreens("О Компании", "account", Icons.Default.Info)
    object HowToFindUs : DrawerScreens("Как нас найти?", "account", Icons.Default.Search)
    object InformationForClients :
        DrawerScreens("Информация для клиентов", "account", Icons.Default.Warning)

    object GetADiscount : DrawerScreens("Получить скидку %", "account", Icons.Default.ThumbUp)
    object Notifications : DrawerScreens("Уведомления", "account", Icons.Default.Face)
    object ReviewsAndSuggestions :
        DrawerScreens("Отзывы и предложения", "account", Icons.Default.Face)

    object Vacancy : DrawerScreens("Вакансии", "account", Icons.Default.MoreVert)
    object Agreement : DrawerScreens("Соглашение", "account", Icons.Default.Face)
    object Share : DrawerScreens("Поделиться", "account", Icons.Default.Share)
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