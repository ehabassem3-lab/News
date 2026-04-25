import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.compose_first.R

import com.example.compose_first.screens.news.changeTheme
import com.example.compose_first.ui.theme.DarkThemeTypography

@Composable
fun DrawerContent(OnHomeClick:()-> Unit, OnThemeClick:()-> Unit)

{
    val colorScheme =  MaterialTheme.colorScheme
    Column(
        modifier = Modifier.fillMaxHeight().fillMaxWidth(.7f).background(colorScheme.background)
    ) {
        Box(

            modifier = Modifier.fillMaxWidth().fillMaxHeight(.2f).background(colorScheme.onBackground),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "News App ",
                style = DarkThemeTypography.bodyLarge,
                fontSize = 25.sp,
                color = colorScheme.background,
                fontWeight = FontWeight.Bold



            )
        }
        Spacer(modifier = Modifier.size(20.dp))
        RowItem(
            Icon = painterResource(R.drawable.ic_home),
            title = "Go To Home",
            onClick = {
                OnHomeClick()

            }

        )
        HorizontalDivider(modifier = Modifier.padding(12.dp), thickness = 4.dp , color = colorScheme.onBackground)
        RowItem(
            Icon = painterResource(R.drawable.ic_roller),
            title = "Theme",
           onClick = {

                   OnThemeClick()
            }


        )
        HorizontalDivider(modifier = Modifier.padding(12.dp), thickness = 4.dp , color = colorScheme.onBackground)
        RowItem(
            Icon = painterResource(R.drawable.ic_globe),
            title = "Language",
            onClick = {

            }

        )




    }
}
@Composable
fun RowItem(Icon: Painter, title: String, onClick: () -> Unit){
    val colorScheme =  MaterialTheme.colorScheme

    Row(
        modifier = Modifier
            .padding(16.dp)
            .clickable{
                onClick()
            }

    )
    {
        Icon(modifier = Modifier.size(25.dp), painter = Icon, contentDescription = "", tint = colorScheme.onBackground)
        Text(modifier = Modifier.padding(start = 15.dp),text = title , fontSize = 25.sp, color = colorScheme.onBackground)


    }


}
