package com.webshop.simplewebapplication;

import com.webshop.simplewebapplication.Service.ItemService;
import com.webshop.simplewebapplication.database.ItemDAOHib;
import com.webshop.simplewebapplication.model.Category;
import com.webshop.simplewebapplication.model.Item;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class ItemServiceTest {

	@InjectMocks
	private ItemService itemService;

	@Mock
	private ItemDAOHib dataBase;

	@Test
	void addItem() {
		Item item = new Item(0, "Морковь", 17, "435633453", new Category(0, "Техника"));
		boolean isItemCreated = itemService.addItem(item);
		Assert.assertTrue(isItemCreated);
		Mockito.verify(dataBase, Mockito.times(1)).addItem(item);
	}

	@Test
	void deleteItem() {
		boolean isItemDeleted = itemService.deleteItem(1);
		Assert.assertTrue(isItemDeleted);
		Mockito.verify(dataBase, Mockito.times(1)).deleteItem(1);
	}

	@Test
	void findAll() {
		List<Item> itemList = new ArrayList<>();
		itemList.add(new Item(0, "Морковь", 17, "957643956", new Category(0, "Продукты2")));
		Mockito.when(dataBase.findAll()).thenReturn(itemList);
		Assert.assertArrayEquals(itemList.toArray(), itemService.findAll().toArray());
	}

	@Test
	void countOfItems() {
		Mockito.when(dataBase.countOfItems()).thenReturn(3);
		Assert.assertEquals(3, itemService.countOfItems());
	}
}
