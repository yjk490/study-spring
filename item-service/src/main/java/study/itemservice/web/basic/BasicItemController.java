package study.itemservice.web.basic;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import study.itemservice.domain.item.Item;
import study.itemservice.domain.item.ItemRepository;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);

        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

//    @PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                       @RequestParam int price,
                       @RequestParam Integer quantity,
                       Model model) {

        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.save(item);

        model.addAttribute("item", item);

        return "basic/item";
    }
//    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item, Model model) {
        itemRepository.save(item);

//        model 자동 추가, 생략 가능
//        model.addAttribute("item", item);

        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item, Model model) {
        itemRepository.save(item);

//        model 자동 추가, 생략 가능.
//        @ModelAttribute name을 지정하지 않아도 클래스 이름의 첫글자를 소문자로 바꾸어 model에 추가해 줌
//        model.addAttribute("item", item);

        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV4(Item item, Model model) {
        itemRepository.save(item);

        // 사용자 정의 클래스인 경우 @ModelAttribute 생략 가능.
        // 파라미터가 기본형인 경우는 @RequestParam 적용됨

        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV5(Item item, Model model) {
        itemRepository.save(item);

        // 사용자 정의 클래스인 경우 @ModelAttribute 생략 가능.
        // 파라미터가 기본형인 경우는 @RequestParam 적용됨

        // PRG 패턴
        return "redirect:/basic/items/" + item.getId();
    }

    @PostMapping("/add")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes) {
        Item savedItem = itemRepository.save(item);

        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);

        // PRG 패턴
        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "basic/editForm";
    }
    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);

        return "redirect:/basic/items/{itemId}";
    }

    /**
     * 테스트 용 데이터
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 20));
        itemRepository.save(new Item("itemB", 5000, 6));
    }
}
