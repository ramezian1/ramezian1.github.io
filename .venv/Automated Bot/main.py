from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.options import Options
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager

# Step 1: Set up WebDriver
driver = webdriver.Chrome(ChromeDriverManager().install())
product_url = "https://www.bestbuy.com/site/nintendo-switch-mario-kart-8-deluxe-bundle-full-game-download-3-mo-switch-online-membership-included-multi/6560569.p?skuId=6560569"
driver.get(product_url)


# Step 3: Add the product to the cart
add_to_cart_button = driver.find_element(By.XPATH, "//div[@id='shop-warranty-selector-16396307-add-to-cart-6560569']/div/div/div/button")
add_to_cart_button.click()

# Step 4: Proceed to Checkout (corrected)
cart_icon = driver.find_element(By.CLASS_NAME, "cart-icon")
cart_icon.click()




# Step 8: Proceed to Checkout
add_to_cart_button = driver.find_element(By.XPATH, "//button[@id='shop-attach-modal-33584106-modal-button']")
add_to_cart_button.click()

# Step 9: Read User Information from Text File
with open("user_info.txt", "r") as file:
    lines = file.readlines()
    name = lines[0].strip()
    last_name = lines[1].strip()
    address = lines[2].strip()
    city = lines[3].strip()
    state = lines[4].strip()
    zip_code = lines[5].strip()
    phone_number = lines[6].strip()
    email_address = lines[7].strip()
    credit_name = lines[8].strip()
    credit_cardnum = lines [9].strip()
    exp_date = lines[10].strip()
    cvv = lines[11].strip()

# Step 10: Fill in Shipping and Payment Details
name_field = driver.find_element_by_name("name")
name_field.send_keys(name)

last_name_field = driver.find_element_by_name("lastname")
last_name_field.send_keys(last_name)

address_field = driver.find_element_by_name("address")
address_field.send_keys(address)

street_field = driver.find_element_by_name("street")
street_field.send_keys(city)

zip_code_field = driver.find_element_by_name("zip")
zip_code_field.send_keys(zip_code)

state_field = driver.find_element_by_name("state")
state_field.send_keys(state)

phone_field = driver.find_element_by_name("phone")
phone_field.send_keys(phone_number)

email_address = driver.find_element_by_name("email")
email_address.send_keys(email_address)

credit_name = driver.find_element_by_name("Name on Card")
credit_name.send_keys(credit_name)

credit_cardnum = driver.find_element_by_name("Credit")
credit_cardnum.send_keys(credit_cardnum)

exp_date = driver.find_element_by_name("Expiration")
exp_date = driver.send_keys(exp_date)

cvv = driver.find_element_by_name("CVV")
exp_date = driver.send_keys(exp_date)

# Step 11: Confirm Purchase
place_order_button = driver.find_element_by_id("place-order-button")
place_order_button.click()

# Step 12: Handle Confirmation
# You can capture the order confirmation details here.

# Step 13: Close the Browser
driver.close()
