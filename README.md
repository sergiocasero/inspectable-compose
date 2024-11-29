
---

# **Inspectable**

**Inspectable** is a Compose Multiplatform library that helps developers debug and visualize recompositions in their Compose UIs. With `Inspectable`, you can track recompositions and see dynamic visual cues like flashing outlines and recomposition counts, making performance optimization more intuitive and efficient.

---

## **Features**

- 🔍 **Visualize recompositions**:
    - Draws a random color-square around components during recompositions.
    - Displays a live recomposition counter on components.

- 🎨 **Easily switchable**:
    - Easily enable or disable the debug tools globally.

- ⚡ **Lightweight and easy to use**:
    - Minimal API integration with Compose's `Modifier`.

---

## **Installation**

1. Add JitPack to your project:
   ```gradle
   repositories {
       maven { url 'https://jitpack.io' }
   }
   ```

2. Include the dependency:
   ```gradle
   dependencies {
       implementation("com.github.sergiocasero:inspectable:0.0.1")
   }
   ```

---

## **Usage**

### **Step 1: Enable Inspectable Globally**
Wrap your root composable in `InspectableUI` to enable or disable visual debugging across your app:

```kotlin
import com.example.inspectable.LocalInspectableConfig

@Composable
fun MyApp() {
    InspectableUI(enabled = true) {
        // Your app content
        AppContent()
    }
}
```

### **Step 2: Apply `inspectable` Modifier**
Add the `Modifier.inspectable()` to the components you want to debug:

```kotlin
import com.example.inspectable.inspectable

@Composable
fun ExampleScreen() {
    var counter by remember { mutableStateOf(0) }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { counter++ },
            modifier = Modifier.inspectable()
        ) {
            Text("Click Me!")
        }

        Text(
            text = "Counter: $counter",
            modifier = Modifier.inspectable()
        )
    }
}
```

---

## **Customization**

You can customize `Inspectable` state using the `InspectableUI`:

### Example:
```kotlin
InspectableUI(
    enabled = true,
) {
    // Your app content
}
```

- **`enabled`**: Toggle the inspectable functionality.

---

## **Example**

Here’s a simple app using `Inspectable`:

```kotlin
@Composable
fun ExampleApp() {
    InspectableUI(enabled = true) {
        var text by remember { mutableStateOf("Hello, World!") }

        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { text = "Clicked!" },
                modifier = Modifier.inspectable()
            ) {
                Text("Change Text")
            }
            Text(
                text = text,
                modifier = Modifier.inspectable()
            )
        }
    }
}
```

---

## **Why Use Inspectable?**

Understanding recompositions is critical for building performant Compose Multiplatform UIs. `Inspectable` simplifies this process by:

- Showing exactly where and when recompositions occur.
- Providing live feedback with minimal setup.
- Helping developers identify unnecessary recompositions or performance bottlenecks.

---

## **License**

This library is licensed under the [MIT License](LICENSE).

---

## **Contributing**

Contributions are welcome! If you have ideas, suggestions, or bug reports, please open an issue or submit a pull request. For major changes, please discuss them in an issue first.

---

## **Contact**

Created and maintained by **[Sergio Casero](https://github.com/sergiocasero)**. If you have any questions or feedback, feel free to reach out!

---
