package online_bookstore.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import online_bookstore.DTO.category.CategoryListResponseDto;
import online_bookstore.DTO.category.CategoryResponseDto;
import online_bookstore.Repository.category.Category;
import online_bookstore.Repository.category.CategoryRepository;

@RequiredArgsConstructor
@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	public CategoryResponseDto findById(Long id) {
		Category entity = categoryRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("해당 카테고리가 없습니다. id = "+id));
		return new CategoryResponseDto(entity);
	}
	
	@Transactional(readOnly = true)
	public List<CategoryListResponseDto> findAll(){
		return categoryRepository.findAll()
				.stream().map(CategoryListResponseDto::new)
				.collect(Collectors.toList());
	}
	
	public String findNameById(Long id) {
		Category entity = categoryRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("해당 카테고리가 없습니다. id = "+id));
		String name = entity.getName();
		return name;
	}
	
	@Transactional(readOnly = true)
	public List<CategoryListResponseDto> findSubCategoryByid(Long id){
		return categoryRepository.findSubCategoryByid(id)
				.stream().map(CategoryListResponseDto::new)
				.collect(Collectors.toList());
	}
	//sub카테고리의 id를 넣으면 그 카테고리의 pid를 id로 갖는 par카테고리 리턴하기
	@Transactional(readOnly = true)
	public List<Category> findParCategoryByid(Long id){
		Long pid = categoryRepository.findPidById(id);
		List<Category> sub = categoryRepository.findSubCategoryByid(pid);
		return sub;
	}
	@Transactional(readOnly = true)
	public List<CategoryListResponseDto> findBigCategory(){
		return categoryRepository.findBigCategory()
				.stream().map(CategoryListResponseDto::new)
				.collect(Collectors.toList());
	}
}
