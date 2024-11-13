def get_headless_driver(no_headless=False):
    from selenium.webdriver.chrome.options import Options
    from selenium import webdriver
    from webdriver_manager.chrome import ChromeDriverManager

    options = Options()

    if not no_headless:
        options.add_argument("--headless")

    return webdriver.Chrome(ChromeDriverManager().install(), options=options)