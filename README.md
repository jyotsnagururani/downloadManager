# JavaFX Download Manager

A simple and powerful Download Manager built using **JavaFX**. It allows users to manage multiple downloads simultaneously with features like:

- ✅ URL Validation with error alerts  
- ✅ User-friendly TableView interface

---

## 📸 Features

- **URL Validation**: Catches malformed or empty URLs with alert dialog.
- **Multithreaded**: Each download runs in a separate thread without freezing the UI.

---

## 📁 Project Structure

src/
├── org.example/
│ ├── DownloadManager.java # JavaFX Controller class
│ ├── DownloadThread.java # Handles downloading in background
│ └── App.java # Launches the JavaFX Application
│
├── org.example.models/
│ └── FileInfo.java # File metadata model with JavaFX properties
│
├── org.example.config/
│ └── AppConfig.java # File metadata config path with JavaFX properties
│
├── resources/
│ └── download_manager.fxml # JavaFX layout

---

## 🚀 Getting Started

### Prerequisites

- Java 18+
- JavaFX SDK

### Setup

1. Clone the repo:
   ```bash
   git clone https://github.com/jyotsnagururani/javafx-download-manager.git
   cd javafx-download-manager

Run App.java to start the application.

⚙️ How It Works
Enter a valid URL in the input field.

Click "Download".

A new row appears in the table with:

File name

Download URL

Status (Starting, Downloading, Done, Failed)

Downloads are saved in the configured path.

🧩 Libraries Used
JavaFX


📌 Future Enhancements
Retry failed downloads

Download speed monitor

File type filters

Integration with external download links manager
