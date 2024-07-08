function filterData() {
  let originalData = [];
  const apiUrlTemplate = 'http://openapi.seoul.go.kr:8088/574345677664646b31303243637a7778/json/landBizInfo/{start}/{end}/';
  const totalDataCount = 25874;
  // const pageSize = 1000;
  const pageSize = 500;

  async function fetchData(start, end) {
    const apiUrl = apiUrlTemplate.replace('{start}', start).replace('{end}', end);
    const response = await fetch(apiUrl);
    const data = await response.json();
    return data.landBizInfo.row;
  }

  async function fetchAllData() {
    const promises = [];
    for (let i = 1; i <= totalDataCount; i += pageSize) {
      promises.push(fetchData(i, i + pageSize - 1));
    }
    const results = await Promise.all(promises);
    originalData = results.flat();
    displayData(originalData);
  }

  function displayData(data) {
    const tableBody = document.getElementById('landBizInfoTable').getElementsByTagName('tbody')[0];
    tableBody.innerHTML = '';

    data.forEach(function (item) {
      const row = document.createElement('tr');

      const fields = ['SYS_REG_NO', 'SGG_CD', 'STDG_CD', 'CGG_CD', 'LGL_DONG_NM', 'ADDR', 'MDT_BSNS_NM', 'BZMN_CONM', 'TELNO'];

      fields.forEach(function (field) {
        const cell = document.createElement('td');
        cell.textContent = item[field] || '';
        row.appendChild(cell);
      });

      tableBody.appendChild(row);
    });
  }

  function filterData() {
    const searchCggCd = document.getElementById('searchCggCd').value.toLowerCase();
    const searchBzmnConm = document.getElementById('searchBzmnConm').value.toLowerCase();
    const searchMdtBsnsNm = document.getElementById('searchMdtBsnsNm').value.toLowerCase();

    const filteredData = originalData.filter(function (item) {
      return (searchCggCd === '' || item.CGG_CD.toLowerCase().includes(searchCggCd)) &&
        (searchBzmnConm === '' || item.BZMN_CONM.toLowerCase().includes(searchBzmnConm)) &&
        (searchMdtBsnsNm === '' || item.MDT_BSNS_NM.toLowerCase().includes(searchMdtBsnsNm));
    });

    displayData(filteredData);
  }

  // 초기 데이터 로드
  fetchAllData();
}