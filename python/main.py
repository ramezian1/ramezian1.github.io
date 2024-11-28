import time
from selenium import webdriver
from selenium.webdriver.support.ui import Select
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
import undetected_chromedriver as uc
from bs4 import BeautifulSoup


def send_click(driver,element):
	condition = EC.visibility_of_element_located((By.CSS_SELECTOR, element))
	first_option = WebDriverWait(driver, 15).until(condition)
	first_option.click()

def send_value(driver,element,val):
	condition = EC.visibility_of_element_located((By.CSS_SELECTOR, element))
	first_option = WebDriverWait(driver, 15).until(condition)
	first_option.clear()
	first_option.send_keys(val)

def main():
    
	options = webdriver.ChromeOptions()
	options.add_experimental_option('excludeSwitches', ['enable-logging'])

	file = open("link.txt",'r')
	link = file.readlines()[0].strip()

	details_file = open('details.txt','r')
	data = details_file.readlines()
	data = [x.split('>')[-1].strip() for x in data]

	mail = data[0].strip()
	phone = data[1].strip()
	fname = data[3].strip()
	lname = data[4].strip()
	address = data[5].strip()
	city = data[6].strip()
	state = data[7].strip()
	zipcode = data[8].strip()
	card = data[2].strip()
	
	refresh_time = 3
	
	driver = webdriver.Chrome()
	driver.get(link)

	inp = input('>>> Press enter after selecting store: ')
	while True:
		
		try:
			condition = EC.visibility_of_element_located((By.CSS_SELECTOR, '.c-button-primary'))
			first_option = WebDriverWait(driver, 5).until(condition)
			first_option.click()

			print('>>> Product added to cart')

			driver.get('https://www.bestbuy.com/cart')

			send_click(driver,'.btn-lg')
			send_click(driver,'.cia-guest-content__continue')
			send_value(driver,'#user\.emailAddress',mail)
			send_value(driver,'#user\.phone',phone)
			send_click(driver,'button.btn')
			

			condition = EC.visibility_of_element_located((By.CSS_SELECTOR, '#expMonth'))
			first_option = WebDriverWait(driver, 15).until(condition)

			sel = Select(driver.find_element_by_css_selector('#expMonth'))
			sel.select_by_value(card.split(':')[1])

			condition = EC.visibility_of_element_located((By.CSS_SELECTOR, '#expYear'))
			first_option = WebDriverWait(driver, 15).until(condition)

			sel = Select(driver.find_element_by_css_selector('#expYear'))
			sel.select_by_value(card.split(':')[2])

			
			send_value(driver,'#firstName',fname)
			send_value(driver,'#lastName',lname)
			send_value(driver,'#street',address)
			send_value(driver,'#city',city)
			send_value(driver,'#state',state)
			send_value(driver,'#zipcode',zipcode)


			condition = EC.visibility_of_element_located((By.CSS_SELECTOR, '#state'))
			first_option = WebDriverWait(driver, 15).until(condition)

			sel = Select(driver.find_element_by_css_selector('#state'))
			sel.select_by_value(state.upper())

			send_value(driver,'#zipcode',zipcode)
			send_click(driver,'.btn-lg')
			input('>>> Order placed, press enter to close: ')
			driver.quit()
			break

		except:
			print('>>> Product not available\nRetrying...')
			time.sleep(refresh_time)
			driver.get(link)

main()
