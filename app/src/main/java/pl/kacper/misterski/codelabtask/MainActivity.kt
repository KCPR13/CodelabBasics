package pl.kacper.misterski.codelabtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.kacper.misterski.codelabtask.MainActivity.Companion.ITEM_WEIGHT
import pl.kacper.misterski.codelabtask.ui.theme.CodelabTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodelabTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  // TutorialContent()
                   // TaskContent()
                    GridContent(getItems())
                }
            }
        }
    }
}

 data class Item(val title: String, val description: String,val background: Color)

@Composable
private fun getItems(): List<Item>{
    val item1 = Item(title = stringResource(R.string.first_title),
        description = stringResource(R.string.first_description),
    background = Color(0xFFD0BCFF))

    val item2 = Item(title = stringResource(R.string.first_title),
        description = stringResource(R.string.first_description),
        background = Color(0xFFEADDFF))

    val item3 = Item(title = stringResource(R.string.first_title),
        description = stringResource(R.string.first_description),
        background = Color(0xFFEADDFF))

    val item4 = Item(title = stringResource(R.string.first_title),
        description = stringResource(R.string.first_description),
        background = Color(0xFFD0BCFF))

    return listOf(item1,item2,item3,item4)
}

@Composable
fun GridContent(models: List<Item>){
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {
            items(models.size) { index ->
                Card(model = models[index],
                    modifier = Modifier.height(maxHeight / 2f))
            }
        }
    }
}

@Composable
 fun Card(
    model: Item,
    modifier: Modifier = Modifier
) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(model.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = model.title,
                modifier = Modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = model.description,
                textAlign = TextAlign.Justify
            )
        }

}


@Composable
fun TaskContent(){
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            TaskImage(modifier = Modifier.align(Alignment.CenterHorizontally))
            TaskStatus(stringResource(R.string.all_tasks_completed), modifier = Modifier
                .padding(vertical = 8.dp)
                .align(Alignment.CenterHorizontally))
            TaskMessage(stringResource(R.string.nice_work), modifier = Modifier.align(Alignment.CenterHorizontally))
        }

    }
}

@Composable
fun TaskMessage(message: String, modifier: Modifier = Modifier) {
    Text(
        text = message,
        modifier = modifier,
        fontSize = 16.sp
    )
}

@Composable
fun TaskStatus(status: String, modifier: Modifier) {
    Text(
        text = status,
        modifier = modifier,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )
}

@Composable
fun TaskImage(modifier: Modifier) {
    Image(painter = painterResource(id = R.drawable.ic_task_completed), contentDescription =null,
        modifier = modifier)
}

@Composable
fun TutorialContent(){
    Column {
        Toolbar(modifier = Modifier.fillMaxWidth())
        Title(title = stringResource(R.string.compose_tutorial), modifier = Modifier.padding(16.dp))
        SubTitle(subtitle = stringResource(R.string.compose_tutorial_subtitle),
        modifier = Modifier.padding(horizontal = 16.dp))
        Description(description = stringResource(R.string.compose_tutorial_description),
        modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun Toolbar(modifier: Modifier){
    Image(painter = painterResource(id = R.drawable.bg_compose_background), contentDescription =null,
    modifier = modifier)
}

@Composable
fun Title(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        modifier = modifier,
        fontSize = 24.sp
    )
}

@Composable
fun SubTitle(subtitle: String, modifier: Modifier = Modifier) {
    Text(
        text = subtitle,
        modifier = modifier,
        textAlign =  TextAlign.Justify
    )
}

@Composable
fun Description(description: String, modifier: Modifier = Modifier) {
    Text(
        text = description,
        modifier = modifier,
        textAlign =  TextAlign.Justify
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CodelabTaskTheme {
       //TutorialContent()
        TaskContent()
    }
}